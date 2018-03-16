package gaba.diiage.org.chillindijon;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import gaba.diiage.org.chillindijon.Models.Etablissement;
import gaba.diiage.org.chillindijon.Models.Location;

public class MainActivity extends AppCompatActivity {

    private static class PoiViewHolder extends RecyclerView.ViewHolder {

        public PoiViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrlApi = getResources().getString(R.string.base_url_api);
        URL baseUrl =null;

        // Création de l url à partir de la string récupérée dans les ressources
        try {
            baseUrl = new URL(baseUrlApi);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        final URL finalBaseUrl = baseUrl;
        AsyncTask<URL, Integer, ArrayList<Etablissement>> task = new AsyncTask<URL, Integer, ArrayList<Etablissement>>() {
            @Override
            protected ArrayList<Etablissement> doInBackground(URL... urls) {



                ListView lstEtablissement = (ListView) findViewById(R.id.lstEtablissement);
                ArrayList<Etablissement> etablissements = new ArrayList<Etablissement>();

                InputStream inputStream = null;
                try {

                    // ouverture du stream depuis l'url
                    inputStream = finalBaseUrl.openStream();

                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder stringBuilder = null;
                    String lineBuffer = null;

                    while ((lineBuffer = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(lineBuffer);


                    }
                    String data = stringBuilder.toString();




                    JSONArray jsonArray = new JSONArray(data);
                    for (int i =0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i); // 1 etablissment
                        JSONObject jsonObjectLocation = jsonObject.getJSONObject("location"); // la location de l'etablissement
                        Location location = new Location(
                                jsonObjectLocation.getString("adress"),
                                jsonObjectLocation.getString("postalCode"),
                                jsonObjectLocation.getString("city"),
                                jsonObjectLocation.getDouble("lat"),
                                jsonObjectLocation.getDouble("lon")
                        );
                        etablissements.add(new Etablissement(
                                jsonObject.getString("id"),
                                jsonObject.getString("type"),
                                jsonObject.getString("name"),
                                location)
                        );
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return etablissements;
            }

            @Override
            protected void onPostExecute(ArrayList<Etablissement> etablissements)
            {
                super.onPostExecute(etablissements);
            }
        }.execute(baseUrl);




    }
}
