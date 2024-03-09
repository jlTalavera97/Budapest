package com.example.budapest.data

import com.example.budapest.R
import com.example.budapest.model.LugaresItem

object Datasource {

    val tipoLugar = listOf(
        LugaresItem.Restaurante(
            name = R.string.restaurantes,
            ubication = "",
            image = R.drawable.ico_restaurante,
            description = "",
            coordinates = Pair("",""),
        ),
        LugaresItem.Actividades(
            name = R.string.actividades,
            ubication = "",
            image = R.drawable.ico_actividades,
            description = "",
            coordinates = Pair("",""),
        ),
        LugaresItem.Monumentos(
            name = R.string.monumentos,
            ubication = "",
            image = R.drawable.ico_monumentos,
            description = "",
            coordinates = Pair("","")
        )
    )

    val restaurantes = listOf(
        LugaresItem.Restaurante(
            name = R.string.beerstro14,
            ubication = "Károlyi St., 12, Budapest",
            image = R.drawable.beerstro_14,
            description = "Encontraras especialidades en carne húngara e internacional en nuestra selección. Nos enfocamos en la creatividad y un pintoresco mundo de sabores. Ofrecemos cervezas artesanas húngaras de nuestros 14 grifos, asi como vinos de la casa.",
            coordinates = Pair("47°29'31.2\"N","19°03'26.2\"E")
        ),
        LugaresItem.Restaurante(
            name = R.string.hoppa_bistro,
            ubication = "Október 6 utca 15, Budapest",
            image = R.drawable.hoppa_bistro,
            description = "Restaurante con estrella Michelin que ofrece una fusión de comida hungara y francesa con ingredientes locales de primera calidad. Todo esto acompañado con su selección de vinos, cerveza artesana y café único",
            coordinates = Pair("47°30'05.1\"N","19°03'03.2\"E")
        ),
        LugaresItem.Restaurante(
            name = R.string.byblos,
            ubication = "Semmelweis utca 1-3., Budapest",
            image = R.drawable.byblos,
            description = "Excelente cocina libanesa con opciones vegetarianas, veganas, halal y opciones sin gluten",
            coordinates = Pair("47°29'39.7\"N","19°03'31.8\"E")
        ),
        LugaresItem.Restaurante(
            name = R.string.lucky_7_burgers,
            ubication = "Piarista utca 1., Budapest",
            image = R.drawable.lucky_7_burgers,
            description = "Comida rápida americana con opciones vegetarianas. Cuenta con mas de 5.000 reviews positivas y esta considerado el restaurante nº 20 de Budapest según TripAdvisor",
            coordinates = Pair("47°29'35.1\"N","19°03'07.3\"E")
        )
    )

    val actividades = listOf(
        LugaresItem.Actividades(
            name = R.string.paseo_barco,
            ubication = "Vigadó tér 7., Budapest",
            image = R.drawable.paseo_barco,
            description = "Si hay una ciudad que destaca por su iluminación nocturna, esa es Budapest. En este crucero disfrutarás de las mejores vistas, ya que el barco es totalmente panorámico y tiene partes descubiertas. Durante el paseo en barco navegaremos por el Danubio desde el Puente Petőfi hasta el primer puente de Isla Margarita, recorriendo Budapest en su totalidad.",
            coordinates = Pair("47°29'46.1\"N","19°02'55.2\"E")
        ),
        LugaresItem.Actividades(
            name = R.string.visita_guiada,
            ubication = "Plaza Kossuth Lajos tér. Budapest",
            image = R.drawable.visita_parlamento,
            description = "El Parlamento de Budapest no solo es la cámara legislativa húngara, sino también uno de los edificios más bonitos de la capital de Hungría. Comprobadlo vosotros mismos en este tour en español que incluye la entrada.",
            coordinates = Pair("47°30'25.1\"N","19°02'48.5\"E")
        ),
        LugaresItem.Actividades(
            name = R.string.free_tour,
            ubication = "Nuestro free tour por Budapest es la mejor visita a pie para conocer la Perla del Danubio con un guía local. ¡Ideal si acabáis de llegar a la capital húngara!",
            image = R.drawable.free_tour,
            description = "Guía por los lugares emblematicos de la ciudad de la mano de un guía local",
            coordinates = Pair("47°30'20.0\"N","19°02'48.0\"E")
        ),
        LugaresItem.Actividades(
            name = R.string.entrada_balneario,
            ubication = "Adquiriendo la entrada al Balneario Széchenyi podréis disfrutar de las termas más famosas de Budapest y una de las más fascinantes del mundo. ¡Será una experiencia única y relajante! Además, tendréis acceso al Museo Pálinka.",
            image = R.drawable.balneario,
            description = "Podrás disfrutar de las termas más famosas de Budapest.",
            coordinates = Pair("47°31'08.0\"N","19°04'57.8\"E")
        )
    )

    val monumentos = listOf(
        LugaresItem.Monumentos(
            name = R.string.parlamento,
            ubication = "Kossuth Lajos tér 1-3, Budapest",
            image = R.drawable.visita_parlamento,
            description = "Considerado el tercer parlamento más grande del mundo, este edificio impresiona por su fachada neo-gótica y un interior, decorado con mármol y oro, en el que destaca su escalera principal, la Antigua Cámara Alta y la Sala de la Cúpula, que guarda su tesoro más preciado, la corona de San Esteban.",
            coordinates = Pair("47°30'25.2\"N","19°02'43.6\"E")
        ),
        LugaresItem.Monumentos(
            name = R.string.puente_cadenas,
            ubication = "Széchenyi Lánchíd, Budapest",
            image = R.drawable.puente_cadenas,
            description = "Flanqueado por dos leones, este precioso puente es una reconstrucción idéntica del construido en 1849 por orden del conde István Szécheny (de ahí su nombre), y fue el primero que unió los distritos de Buda y Pest, hasta que los alemanes lo destruyeran durante la Segunda Guerra Mundial, cuando se retiraban de la ciudad.",
            coordinates = Pair("47°29'55.8\"N","19°02'34.4\"E")
        ),
        LugaresItem.Monumentos(
            name = R.string.mercado_central,
            ubication = "Vámház krt. 1-3, Budapest",
            image = R.drawable.mercado_central,
            description = "De estilo neogótico, este imponente edificio sorprende por la combinación de ladrillo y una gran estructura de hierro que permite la entrada de luz natural. Además, dispone de una planta baja con numerosos puestos de fruta, verdura, carne y alimentos tradicionales de la cocina húngara, mientras que en el piso superior hay souvenirs y puestos de comida local para probar platos como el lángos.",
            coordinates = Pair("47°29'14.4\"N","19°03'29.6\"E")
        ),
        LugaresItem.Monumentos(
            name = R.string.basilica,
            ubication = "Szent István tér 1, Budapest",
            image = R.drawable.basilica_san_esteban,
            description = "De estilo neoclásico, este enorme templo está dedicado a San Esteban, primer rey de Hungría, y en su interior además de numerosas obras de arte, se guarda como reliquia la mano derecha del rey y la campana más grande del país.",
            coordinates = Pair("47°30'03.4\"N","19°03'17.2\"E")
        )
    )
}