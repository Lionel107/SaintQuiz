package com.example.gestionprofil;

import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoursActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textToSpeech.isSpeaking()){
                textToSpeech.speak("a nutrition est l'étude des aliments et des nutriments qui les composent, et de la manière dont ils affectent notre santé. Il existe différents groupes alimentaires, chacun offrant des nutriments clés pour notre corps. La viande est un groupe d'aliments important pour fournir des protéines, qui sont essentielles pour la croissance et la réparation des tissus corporels. D'autres sources de protéines incluent les légumineuses, les noix et les graines.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Les produits laitiers sont une excellente source de calcium, un minéral important pour la construction et l'entretien des os et des dents. Les produits laitiers comprennent le lait, le fromage et le yaourt. Les personnes qui ne consomment pas de produits laitiers peuvent obtenir du calcium à partir d'autres sources telles que les légumes verts, les noix et les graines.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Lorsqu'il s'agit de graisses, il est important de choisir les bonnes. Les graisses monoinsaturées, telles que celles présentes dans les avocats, les noix et les olives, sont bénéfiques pour la santé cardiaque et aident à réduire le taux de cholestérol sanguin. Les graisses saturées et les graisses trans, que l'on trouve souvent dans les aliments frits, les viandes grasses et les aliments transformés, peuvent augmenter le risque de maladies cardiaques et d'autres problèmes de santé.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"La vitamine A est importante pour la vision et pour maintenir un système immunitaire sain. Les aliments riches en vitamine A comprennent les carottes, les épinards et les patates douces.\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Les glucides sont une source d'énergie importante pour notre corps. Les pâtes et les pains sont un groupe d'aliments qui fournissent des glucides, mais il est important de choisir des versions complètes qui offrent également des fibres pour la santé digestive.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Les fruits et légumes sont une excellente source de fibres, qui sont importantes pour la santé digestive et pour aider à maintenir un taux de cholestérol sain. Les fruits et légumes contiennent également de la vitamine C, qui est importante pour la santé immunitaire.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Le sel iodé est la meilleure option pour la santé car il fournit de l'iode, un minéral important pour la santé thyroïdienne. D'autres types de sel, tels que le sel de mer ou le sel rose de l'Himalaya, peuvent avoir des avantages pour la saveur et la texture des aliments, mais ne fournissent pas d'iode.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"La viande est une source importante de fer, un minéral important pour la formation des globules rouges et pour prévenir l'anémie. D'autres sources de fer comprennent les légumineuses, les épinards et les céréales enrichies.\\n\" +\n" +
                        "                            \"\\n\" +\n" +
                        "                            \"Les noix et les graines sont une source de graisses insaturées, qui sont bénéfiques pour la santé cardiaque. Ils contiennent également des vitamines et des minéraux importants, tels que la vitamine E et le magnésium", TextToSpeech.QUEUE_FLUSH, null);
            }else {
                   // textToSpeech.playSilence(1000, TextToSpeech.QUEUE_FLUSH, null);
                    textToSpeech.stop();

                }
            }
        });


        initTextToSpeech();
    }
    private void initTextToSpeech() {

    }

}