package com.example.librosfavoritos.base;

import android.database.sqlite.SQLiteDatabase;

import com.example.librosfavoritos.R;

import static com.example.librosfavoritos.base.EstructuraBD.TablaContenido.*;

// Base Inicial
public final class BaseInicial {


    public static long crearLibro(SQLiteDatabase db, Libro libro){
        return db.insert(
                NOMBRE_TABLA,
                null,
                libro.toContentValues());
    }
    public static void llenarBase(SQLiteDatabase db){

        crearLibro(db, new Libro(
                "Dune",
                "Brian Herbert y Kevin J. Anderson",
                "Penguin Random House Grupo Editorial España",
                "2017",
                "450",
                "Castellano",
                "Ficción",
                "El emperador Shaddam Corrino anhela lo que aún no posee: el poder absoluto y un heredero varón. En su camino se interponen la Cofradía Espacial, que le impide controlar el comercio de la melange, la especia adictiva que mantiene unido al imperio; las rivalidades entre Casas, especialmente entre el duque Leto Atreides y el barón Harkonnen, y los oscuros planes de la hermandad Bene Gesserit. Todos ignoran, sin embargo, que el destino de la civilización está ahora en manos de una mujer decidida, por amor, a desbaratar el plan secular de la Hermandad para crear el todopoderoso Kwisatz Haderach. Si lady Jessica da a luz el hijo varón que tanto ansía el duque Leto, podría alterarse la historia futura del imperio",
                R.drawable.dune,
                "NO"));

        crearLibro(db, new Libro(
                "Contacto",
                "Carl Sagan",
                "NOVA",
                "1985",
                "432",
                "Castellano",
                "Ficción",
                "Tras cinco años de incesantes búsquedas con los dispositivos más sofisticados del momento, la astrónoma Eleanor Arroway consigue, junto a un equipo de científicos internacionales, conectar con la estrella Vega y demostrar que no estamos solos en el universo.",
                R.drawable.contacto,
                "SI"));

        crearLibro(db, new Libro(
                "El Hombre en el Castillo",
                "Philip K. Dick",
                "Minotauro",
                "2014",
                "261",
                "Castellano",
                "Ficción",
                "El Hombre en el Castillo nos sumerge en un mundo alternativo en el cual el Eje ha derrotado a los Aliados en la segunda guerra mundial y los Estados Unidos han sido invadidos y divididos entre los vencedores. Mientras los nazis se han anexionado la costa atlántica, donde han instaurado un régimen de terror, la costa pacífica permanece en manos japonesas. En esta América invadida, los nativos son ciudadanos de segunda clase a pesar de que su cultura es admirada por los vencedores, hasta el punto de que uno de los mejores negocios es la venta de auténticas antigüedades americanas, como relojes de Mickey Mouse o chapas de Coca-Cola. Quizá sea la mejor obra de Dick y la más notable de las narraciones sobre mundos alternativos que se haya escrito jamás.",
                R.drawable.elhombreenelcastillo,
                "NO"));

        crearLibro(db, new Libro(
                "El Instituto",
                "Stephen King",
                "Penguin Random House Grupo Editorial España",
                "2019",
                "608",
                "Castellano",
                "Terror",
                "En mitad de la noche en un barrio tranquilo de Minneapolis raptan a Luke Ellis, de doce años, tras haber asesinado a sus padres. Una operación que dura menos de dos minutos. Luke se despierta en la siniestra institución conocida como el Instituto, en un cuarto que se asemeja al suyo pero sin ventanas. En habitaciones parecidas hay más niños: Kalisha, Nick, George, Iris y Avery Dixon, entre otros, que comparten capacidades especiales como la telequinesia o la telepatía. Todos ellos se alojan en la Mitad Delantera de la institución. Los mayores, en cambio, se encuentran en la Mitad Trasera. Como dice Kalisha: «El que entra no sale».",
                R.drawable.elinstituto,
                "NO"));

        crearLibro(db, new Libro(
                "Buenos Aires es leyenda",
                "Guillermo Barrantes y Víctor Coviello",
                "Planeta",
                "2004",
                "328",
                "Castellano",
                "Ficción",
                "Buenos Aires Es Leyenda. Hace siete años, Guillermo Barrantes y Víctor Coviello recorrieron por primera vez la Ciudad en busca de las leyendas urbanas más sorprendentes de cada barrio porteño. ... Buenos Aires es leyenda es la única trilogía de mitos urbanos de la misteriosa Buenos Aires.",
                R.drawable.buenosaires,
                "NO"));

        crearLibro(db, new Libro(
                "Yo soy el Diego",
                "Diego Armando Maradona",
                "Planeta",
                "2000",
                "336",
                "Castellano",
                "Biografía",
                "“A veces pienso que toda mi vida está filmada, que toda mi vida está en las revistas. Y no es así, ¿eh?, no es así. Hay cosas que están sólo acá adentro, en mi corazón, y que nadie sabe”, dice Diego Armando Maradona en este libro. ¿Quién conoce la historia de Maradona mejor que él mismo? ¿Quién se animaría a interpretar qué pasaba por su cabeza antes de dormir en una piecita de dos por dos, en Fiorito, acompañado por sus siete hermanos? ¿Quién osaría afirmar cuál fue su mayor alegría y su peor tristeza? Nadie mejor que el propio Diego, perdón, “El Diego… de la gente”, como a él le gusta ser y que lo llamen.",
                R.drawable.diego,
                "SI"));

        crearLibro(db, new Libro(
                "Historias fantásticas",
                "Stephen King",
                "Penguin Random House Grupo Editorial España",
                "1992",
                "256",
                "Castellano",
                "Terror",
                "Siguiendo la tradición de Poe, Stevenson y Lovecraft, King nos abre la puerta de acceso a un mundo de horrores inimaginables. Stephen King ha fundido aquí imágenes de terrores ancestrales con la iconografía de la actual sociedad norteamericana. Los relatos incluidos en este libro, originales y trepidantes, han cautivado a millones de lectores en todo el mundo.",
                R.drawable.historias_fantasticas,
                "NO"));

        crearLibro(db, new Libro(
                "Los mitos de la historia Argentina",
                "Felipe Pigna",
                "Booket",
                "2013",
                "496",
                "Castellano",
                "Historia",
                "Felipe Pigna nos convoca para conocer nuestra historia, para saber de dónde venimos, por qué estamos como estamos, quiénes somos y quiénes podemos ser.\n" +
                        "El estudio de vidas entregadas apasionadamente a una causa –Bouchard, Güemes, Do-rrego–, de personalidades polémicas –Rosas, Sarmiento– y de temas con una asombrosa resonancia actual –el genocidio de la conquista del desierto, la primera deuda externa argentina, las protestas sociales de hace un siglo– le permitirá al lector comprobar que la historia argentina no se repite, se continúa.",
                R.drawable.mitos,
                "NO"));

        crearLibro(db, new Libro(
                "Putin's Russia",
                "Anna Politkovskaya",
                "ed",
                "2003",
                "290",
                "Inglés",
                "Política",
                "Traducción del inglés-Putin's Russia es un libro de comentarios políticos de la fallecida periodista rusa Anna Politkovskaya sobre la vida en la Rusia moderna. Politkovskaya argumenta que Rusia todavía tiene aspectos de un estado policial o mafioso, bajo el liderazgo de Vladimir Putin.",
                R.drawable.putin,
                "NO"));

        crearLibro(db, new Libro(
                "Quien vota a la derecha",
                "Alberto Garzón",
                "Ediciones Península",
                "2019",
                "200",
                "Castellano",
                "Política",
                "En los últimos años se ha extendido la tesis de que la culpa de la victoria de Donald Trump en Estados Unidos y del brexit en el referéndum del Reino Unido, así como del ascenso de la ultraderecha en muchos países de la Unión Europea, la tiene la clase trabajadora. En nuestro país se sigue escuchando en los bares que no hay nadie más equivocado que un obrero de derechas, mientras Ciudadanos, el PP y Vox crecen en las encuestas.",
                R.drawable.quienvotaladerecha,
                "NO"));

        crearLibro(db, new Libro(
                "Sinceramente",
                "Cristina Fernandez de Kirchner",
                "Editorial Sudamericana",
                "2019",
                "600",
                "Castellano",
                "Política",
                "«Este libro no es autobiográfico ni tampoco una enumeración de logros personales o políticos, es una mirada y una reflexión retrospectiva para desentrañar algunos hechos y capítulos de la historia reciente y cómo han impactado en la vida de los argentinos y en la mía también.»",
                R.drawable.sinceramente,
                "NO"));

        crearLibro(db, new Libro(
                "La tierra errante",
                "Cixin Liu",
                "NOVA",
                "2019",
                "400",
                "Castellano",
                "Ficción",
                "El sol se está muriendo, y la Tierra, consumida por los últimos suspiros de esta estrella, también desaparecerá. Pero la humanidad, en lugar de abandonar el planeta, construye doce mil grandiosos motores de fusión para desorbitar la Tierra y propulsarla hacia Próxima Centauri en un viaje que durará siglos...",
                R.drawable.tierraerrante,
                "NO"));
    }
}
