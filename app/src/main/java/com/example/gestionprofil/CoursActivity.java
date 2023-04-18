package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class CoursActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private boolean isPaused = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused==true){
                    isPaused = false;
                textToSpeech.speak("Les groupes alimentaires :                                                            Les groupes alimentaires sont des catégories d'aliments qui fournissent des nutriments essentiels pour notre corps.\n" +
                        "La nutrition est l'étude de la manière dont les aliments interagissent avec notre corps et fournissent les nutriments essentiels pour notre santé. Il existe plusieurs groupes alimentaires, chacun offrant des nutriments clés pour notre corps. Les groupes alimentaires les plus courants sont les protéines, les produits laitiers, les graisses, les vitamines, les glucides, les fruits et légumes et les minéraux. Les protéines sont essentielles pour la croissance et la réparation des tissus corporels, tandis que les produits laitiers sont une excellente source de calcium, important pour la construction et l'entretien des os et des dents.\n" +
                        "\n" +
                        "                                                                                                 Les graisses :\n" +
                        "\n" +
                        "Les graisses sont un autre élément important de notre alimentation. Les graisses monoinsaturées, telles que celles présentes dans les avocats, les noix et les olives, sont bénéfiques pour la santé cardiaque et aident à réduire le taux de cholestérol sanguin. D'un autre côté, les graisses saturées et les graisses trans, présentes dans les aliments frits, les viandes grasses et les aliments transformés, peuvent augmenter le risque de maladies cardiaques et d'autres problèmes de santé.\n" +
                        "\n" +
                        "Les vitamines et les minéraux :\n" +
                        "Les vitamines et les minéraux sont également essentiels pour notre santé. La vitamine A est importante pour la vision et pour maintenir un système immunitaire sain, tandis que la vitamine C est importante pour la santé immunitaire. Le fer est important pour la formation des globules rouges et pour prévenir l'anémie. Les fruits et légumes sont une excellente source de fibres, qui sont importantes pour la santé digestive et pour aider à maintenir un taux de cholestérol sain.\n" +
                        "\n" +
                        "Les glucides :\n" +
                        "Les glucides sont une source d'énergie importante pour notre corps. Les pâtes et les pains sont un groupe d'aliments qui fournissent des glucides, mais il est important de choisir des versions complètes qui offrent également des fibres pour la santé digestive. Les fruits et légumes sont également une excellente source de glucides complexes, qui sont riches en fibres et en vitamines.\n" +
                        "\n" +
                        "Le sel :\n" +
                        "Le sel est un autre élément important de notre alimentation, mais il est important de choisir le bon type de sel. Le sel iodé est la meilleure option pour la santé car il fournit de l'iode, un minéral important pour la santé thyroïdienne. D'autres types de sel, tels que le sel de mer ou le sel rose de l'Himalaya, peuvent avoir des avantages pour la saveur et la texture des aliments, mais ne fournissent pas d'iode.\n" +
                        "\n" +
                        "Les noix et les graines :\n" +
                        "Les noix et les graines sont une excellente source de graisses insaturées, qui sont bénéfiques pour la santé cardiaque. Ils contiennent également des vitamines et des minéraux importants, tels que la vitamine E et le magnésium. Les noix et les graines sont également riches en fibres et peuvent être utilisées pour ajouter de la texture et de la saveur aux aliments.", TextToSpeech.QUEUE_FLUSH, null);
            }else {
                   // textToSpeech.playSilence(1000, TextToSpeech.QUEUE_FLUSH, null);
                    textToSpeech.stop();
                    isPaused = true;
                }
            }
        });
        initTextToSpeech();
    }

    private void initTextToSpeech() {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.FRENCH);
                }
            }
        });
    }


}