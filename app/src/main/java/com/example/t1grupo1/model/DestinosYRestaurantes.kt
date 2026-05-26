package com.example.t1grupo1.model

data class Comida(
        val id: Int,
        val nombreComida: String,
        val precio: Double
)

object ComidaData {
    val comidas = listOf(
            Comida(1, "Cuy al horno", 25.0),
            Comida(2, "Ceviche", 45.0),
            Comida(3, "Rocoto relleno", 18.0),
            Comida(4, "Sánguche de chancho", 15.0)
    )
}

data class Lugar(
        val id: Int,
        val estado: Boolean,
        val nombreLugar: String,
        val ubicacion: String,
        val descripcion: String,
        val imagen: String,
        val comidaId: Int
)

object LugarData {
        val lugares = listOf(
                Lugar(
                        1,
                        true,
                        "Mercado San Pedro",
                        "Cusco",
                        "Mercado tradicional emblemático de Cusco donde se encuentran productos locales, comida típica andina, jugos naturales y platos preparados al instante en un ambiente cultural y turístico.",
                        "https://imgs.search.brave.com/FQSC89H6fdZgF6pFUHKNOYLOrDIlnTRCwASiNIXTyBI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9mYXN0/bHkuNHNxaS5uZXQv/aW1nL2dlbmVyYWwv/NjAweDYwMC82ODcy/NzI1MF84R1ZOTzk0/dC1neDJ2WnBxaU9q/M2dFMmxhQWtfMzB2/NzdGVHRXTFB0OVB3/LmpwZw",
                        1
                ),
                Lugar(
                        2,
                        true,
                        "La Mar",
                        "Lima",
                        "Cevichería reconocida por su propuesta gastronómica moderna basada en pescados y mariscos frescos, con preparaciones innovadoras de la cocina peruana contemporánea.",
                        "https://imgs.search.brave.com/0xrRYmY2ITKB6KuEgcqnDd-kyGOSFAznBqdSrnHO0aE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9oaXBz/LmhlYXJzdGFwcHMu/Y29tL2htZy1wcm9k/L2ltYWdlcy9yZXN0/YXVyYW50ZS1sYS1t/YXItZ2FzdG9uLWFj/dXJpby1lbGxlLWdv/dXJtZXQtMy02N2U3/YTY0ZDBjNTI5Lmpw/Zz9yZXNpemU9OTgw/Oio",
                        2
                ),
                Lugar(
                        3,
                        false,
                        "Picantería Solimar",
                        "Arequipa",
                        "Picantería tradicional arequipeña que ofrece platos típicos como rocoto relleno, chupe y adobos, manteniendo recetas ancestrales y el sabor auténtico del sur del Perú.",
                        "https://imgs.search.brave.com/FsQzNED639D0m8VveowaM8FNRdtI3Sk2lfwyiVHGGHQ/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2h1bGxvc3RyYXZl/bHBlcnUuY29tL2Js/b2cvd3AtY29udGVu/dC91cGxvYWRzLzIw/MjUvMTEvSG93LXRv/LXNhdmUtbW9uZXkt/dHJhdmVsaW5nLXRo/cm91Z2gtUGVydS4t/NDAucG5n",
                        3
                ),
                Lugar(
                        4,
                        true,
                        "La Lucha Sanguchería",
                        "Lima",
                        "Sanguchería popular en Lima conocida por sus sándwiches artesanales preparados al momento con ingredientes frescos y combinaciones clásicas de la gastronomía peruana urbana.",
                        "https://imgs.search.brave.com/D29quIbDa0-KODZlTXfRQwD3DN6mlmlX8gh-rgONGtA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS1jZG4udHJpcGFk/dmlzb3IuY29tL21l/ZGlhL3Bob3RvLW8v/MDkvN2YvOWYvNTgv/bGEtbHVjaGEtc2Fu/Z3VjaGVyaWEuanBn",
                        4
                )
        )
}