package com.ignacio.appnoticias

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ignacio.appnoticias.classes.Noticias
import com.ignacio.appnoticias.databinding.ActivityMainBinding
import com.ignacio.appnoticias.mainModule.adapter.NoticiasAdapter
import com.ignacio.appnoticias.mainModule.adapter.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var noticiasAdapter: NoticiasAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noticiasAdapter = NoticiasAdapter(getNoticias(), this)
        linearLayoutManager = LinearLayoutManager(this)

        mBinding.rcv.apply {
            layoutManager = linearLayoutManager
            adapter = noticiasAdapter
        }
    }

    private fun getNoticias(): MutableList<Noticias>{
        val noticias = mutableListOf<Noticias>()
        val noticia1 = Noticias(1,
            "Toyota anuncia el regreso del Celica",
            "Toyota ha hecho saltar todas las alarmas de los amantes de los deportivos. De una manera un tanto peculiar, altos directivos de la marca han confirmado que ya se encuentra en pleno desarrollo una nueva entrega de este afamado coche, muy popular en los 90’ por el éxito que obtuvo Carlos Sainz, padre, con sus versiones de rally.",
            "12/07/2024",
            "https://i.postimg.cc/wj70c1r3/maxresdefault.jpg",
            "https://www.autopista.es/novedades-coches/toyota-confirma-oficialmente-regreso-celica-mercado-sera-nuevo-deportivo_302950_102.html")

        val noticia2 = Noticias(2,
            "Netflix estrena serie sobre Ayrton Senna",
            "Treinta años después de su muerte en un accidente a toda velocidad, visto por millones de personas en el mundo, la vida del campeón de Fórmula Uno Ayrton Senna, llena de adrenalina, está a punto de ser presentada también ante un público global.",
            "27/11/2024",
            "https://cdn.motor1.com/images/mgl/9VWNv/s1/4x3/todos-os-carros-que-ayton-senna-ja-dirigiu.webp",
            "https://www.latimes.com/espanol/entretenimiento/articulo/2024-11-27/nueva-serie-de-netflix-retrata-intensa-vida-del-legendario-ayrton-senna")

        val noticia3 = Noticias(3,
            "Audi S5, asi sera nueva berlina.",
            "El Audi A5 2025 combina lo mejor de la gama A4 y el anterior A5, con una propuesta que se posiciona en el segmento medio superior. Mide 4,82 metros de largo, 1,86 metros de ancho y tiene una altura de 1,46 metros en la versión berlina o 1,44 metros en el Avant.",
            "29/11/2024",
        "https://fotos.quecochemecompro.com/audi-a5-sportback/audi-a5-dinamismo-elegancia.jpg?size=750x400",
            "https://www.coches.net/videos/audi-s5-2025")

        val noticia4 = Noticias(4,
            "El precio del nuevo Bugatti es una locura",
            "Casi que se cuentan con los dedos de una mano las marcas de coches más prestigiosas del mundo, pero la batalla entre los más ricos se dirime entre dos: francesa o italiana. La personalización es el área donde Bugatti y Ferrari ganan más dinero, pero la transalpina está muy lejos de lo que algunas opciones cuestan en la marca de Molsheim.",
            "30/11/2024",
            "https://cdn-images.motor.es/image/m/1320w/fotos-noticias/2024/11/bugatti-2024105529-1732901063_2.jpg",
            "https://www.motor.es/noticias/precio-bugatti-mistral-record-2024105529.html")

        val noticia5 = Noticias(5,
            "Max Verstappen, sancionado.",
            "Max Verstappen no iba a acabar la temporada sin hacer una última pole position. Cuando nadie lo esperaba, Red Bull ha recuperado mágicamente el rendimiento en Catar, y Verstappen ha podido marcarse una pole position que no lograba desde Austria. El campeón ha parado el crono en 1:20.520, 55 milésimas más rápido que su perseguidor.",
            "30/11/2024",
            "https://www.latribunadealbacete.es/media/IMG/2024/F1096932-93D8-D768-13CA30543428D074.JPG",
            "https://www.motorpasion.com/formula1/max-verstappen-rompe-su-sequia-poles-vuelta-magica-catar-fernando-alonso-hace-otro-pequeno-milagro")

        val noticia6 = Noticias(6,
            "KTM a punto de quebrar.",
            "A través de un comunicado oficial emitido el 25 de noviembre de 2024, Pierer Industrie AG, propietaria de KTM, declaró entrar en concurso de acreedores. Esta noticia ha sido demoledora para la industria europea. El mayor fabricante de motos de Europa está en una situación complicada y si no maniobran con habilidad, el gigante de las motos del viejo continente se puede caer.",
            "29/11/2024",
            "https://img.remediosdigitales.com/701278/ktm-crisis--5-/1366_2000.jpeg",
            "https://www.motorpasion.com/industria/mayor-fabricante-motos-europa-esta-quiebra-mejor-opcion-para-ktm-rescate-megacorporacion-india-bajaj")

        val noticia7 = Noticias(7,
            "Monza se queda en la F1 hasta 2031",
            "La Fórmula 1 se puede expandir por todo el mundo y en circuitos con poco pedigrí, pero se cuida muy mucho de no perder los pilares del campeonato. Si hace poco renovaba Mónaco, hoy se anuncia que el Gran Premio de Italia permanecerá en el calendario hasta 2031 inclusive, como en el Principado, y como parte de una nueva extensión de seis años del acuerdo existente, que se extendía hasta 2025.",
            "28/11/2024",
            "https://phantom-marca.unidadeditorial.es/9ffe62fafc5e86adefeb1ed281a40376/resize/828/f/webp/assets/multimedia/imagenes/2024/11/28/17328157395605.jpg",
            "https://www.marca.com/motor/formula1/gp-qatar-f1/2024/11/28/6748a98046163fce328b459c.html")

        val noticia8 = Noticias(8,
            "El Toyota GR Supra se despide por todo lo alto",
            "El regreso del Toyota Supra fue uno de los más laureados del pasado reciente de la industria, pero, aunque no lo parezca, tuvo lugar hace ya unos cuantos años. Así, la actual generación del deportivo nipón se acerca al final de su ciclo de vida y la marca quiere que diga adiós de la mejor manera posible, con el Toyota GR Supra A90 Final Edition.",
            "30/11/2024",
            "https://hips.hearstapps.com/hmg-prod/images/toyota-gr-supra-a90-final-edition-4-674878c4824ec.jpg?crop=0.7500881212548467xw:1xh;center,top&resize=1200:*",
            "https://motor.elpais.com/actualidad/el-toyota-gr-supra-se-despide-por-todo-lo-alto/")

        val noticia9 = Noticias(9,
            "El BMW M3 GTR de Need for Speed ya es un coche de verdad",
            "Si eres un aficionado al mundo de los videojuegos seguro que este coche te traerá buenos recuerdos, especialmente, si te gustan las sagas que dominaron las videoconsolas a principios de los 2000. Hablamos de un modelo con el que, por aquellos entonces adolescentes, todos hemos soñado poder conducir en la realidad en algún momento.",
            "29/11/2024",
            "https://cdn.motor1.com/images/mgl/eoKjQP/s1/bmw-m3-gtr-from-2005-s-need-for-speed-most-wanted.webp",
            "https://es.motor1.com/news/742380/bmw-m3-gtr-need-fo-speed-2005/")

        val noticia10 = Noticias(10,
            "El Rally de Japón, multado por las infracciones de seguridad",
            "Los organizadores del Rally de Japón han sido sancionados con una multa efectiva de 50.000 euros, además de otros 100.000 en suspensión, después de que un vehículo no autorizado entrara en el recorrido en un tramo que se estaba disputando en la cita final de la temporada 2024 del Mundial de Rallies.",
            "24/11/2024",
            "https://cdn-7.motorsport.com/images/amp/24vwzye6/s1200/elfyn-evans-scott-martin-toyot.webp",
            "https://es.motorsport.com/wrc/news/rally-japon-multa-infracciones-seguridad/10676210/")


        noticias.add(noticia1)
        noticias.add(noticia2)
        noticias.add(noticia3)
        noticias.add(noticia4)
        noticias.add(noticia5)
        noticias.add(noticia6)
        noticias.add(noticia7)
        noticias.add(noticia8)
        noticias.add(noticia9)
        noticias.add(noticia10)




        return noticias
    }

    override fun onClick(noticias: Noticias) {
        val url = "${noticias.url}"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onLongClick(noticias: Noticias) {
        Toast.makeText(this, "${noticias.titular}", Toast.LENGTH_SHORT).show()    }
}