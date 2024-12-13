package www.laytandroid000;

import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParser;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        FrameLayout container = findViewById(android.R.id.content);

        // Recupera o código XML passado pela MainActivity
        String xmlCode = getIntent().getStringExtra("LAYOUT_XML");
        if (xmlCode != null) {
            try {
                // Analisa e inflata o layout dinamicamente
                XmlPullParser parser = Xml.newPullParser();
                parser.setInput(new java.io.StringReader(xmlCode));

                LayoutInflater inflater = LayoutInflater.from(this);
                View dynamicView = inflater.inflate(parser, container, false);

                // Adiciona o layout ao container
                container.removeAllViews();
                container.addView(dynamicView);
            } catch (Exception e) {
                // Mostra um erro se o XML estiver inválido
                Toast.makeText(this, "Erro ao carregar o layout. Verifique o código XML.", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}
