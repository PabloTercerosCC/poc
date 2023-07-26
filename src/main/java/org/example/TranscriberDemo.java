package org.example;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class TranscriberDemo {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("/home/fundacion/Documents/sem6/prog6/code/sphinx-poc/src/main/java/org/example/dictionary/cmusphinx-es-5.2/model_parameters/voxforge_es_sphinx.cd_ptm_4000");
        configuration.setDictionaryPath("/home/fundacion/Documents/sem6/prog6/code/sphinx-poc/src/main/java/org/example/dictionary/es.dict");
        configuration.setLanguageModelPath("/home/fundacion/Documents/sem6/prog6/code/sphinx-poc/src/main/java/org/example/dictionary/es-20k.lm");

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

        System.out.println("Escuchando...");

        recognizer.startRecognition(true);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hipótesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }
}
