package com.diegorb.tiempo.domain.tiempo

import androidx.annotation.DrawableRes
import com.diegorb.tiempo.R

/*
Contiene los objetos correspondientes a cada uno de los tipos de tiempo meteorológico
 */
sealed class TipoTiempo(
    val tiempoDesc: String,
    @DrawableRes val iconRes: Int
) {
    object Soleado : TipoTiempo(
        tiempoDesc = "Soleado",
        iconRes = R.drawable.ic_sunny
    )
    object MayormenteSoleado : TipoTiempo(
        tiempoDesc = "Mayormente soleado",
        iconRes = R.drawable.ic_cloudy
    )
    object MayormenteNublado : TipoTiempo(
        tiempoDesc = "Mayormente nublado",
        iconRes = R.drawable.ic_cloudy
    )
    object Nublado : TipoTiempo(
        tiempoDesc = "Nublado",
        iconRes = R.drawable.ic_cloudy
    )
    object Niebla : TipoTiempo(
        tiempoDesc = "Niebla",
        iconRes = R.drawable.ic_very_cloudy
    )
    object Rocio : TipoTiempo(
        tiempoDesc = "Rocío",
        iconRes = R.drawable.ic_very_cloudy
    )
    object LloviznaLigera : TipoTiempo(
        tiempoDesc = "Llovizna ligera",
        iconRes = R.drawable.ic_rainshower
    )
    object Llovizna : TipoTiempo(
        tiempoDesc = "Llovizna",
        iconRes = R.drawable.ic_rainshower
    )
    object LloviznaDensa : TipoTiempo(
        tiempoDesc = "Llovizna densa",
        iconRes = R.drawable.ic_rainshower
    )
    object LluviGelidaLigera : TipoTiempo(
        tiempoDesc = "Lluvia gélida ligera",
        iconRes = R.drawable.ic_snowyrainy
    )
    object LluviaGelidaDensa : TipoTiempo(
        tiempoDesc = "Lluvia gélida densa",
        iconRes = R.drawable.ic_snowyrainy
    )
    object LluviaLigera : TipoTiempo(
        tiempoDesc = "Lluvia ligera",
        iconRes = R.drawable.ic_rainy
    )
    object Lluvia : TipoTiempo(
        tiempoDesc = "Lluvia",
        iconRes = R.drawable.ic_rainy
    )
    object LluviaIntensa : TipoTiempo(
        tiempoDesc = "Lluvia intensa",
        iconRes = R.drawable.ic_rainy
    )
    object AguanieveIntesa: TipoTiempo(
        tiempoDesc = "Aguanieve intensa",
        iconRes = R.drawable.ic_snowyrainy
    )
    object NieveLigera: TipoTiempo(
        tiempoDesc = "Nieve ligera",
        iconRes = R.drawable.ic_snowy
    )
    object Nieve: TipoTiempo(
        tiempoDesc = "Nieve",
        iconRes = R.drawable.ic_heavysnow
    )
    object NieveIntensa: TipoTiempo(
        tiempoDesc = "Nieve intensa",
        iconRes = R.drawable.ic_heavysnow
    )
    object Granizo: TipoTiempo(
        tiempoDesc = "Granizo",
        iconRes = R.drawable.ic_heavysnow
    )
    object AguaceroLigero: TipoTiempo(
        tiempoDesc = "Aguacero ligero",
        iconRes = R.drawable.ic_rainshower
    )
    object Aguacero: TipoTiempo(
        tiempoDesc = "Aguacero",
        iconRes = R.drawable.ic_rainshower
    )
    object AguaceroIntenso: TipoTiempo(
        tiempoDesc = "Aguacero intenso",
        iconRes = R.drawable.ic_rainshower
    )
    object NebadaLigera: TipoTiempo(
        tiempoDesc = "Nebada ligera",
        iconRes = R.drawable.ic_snowy
    )
    object NebadaIntensa: TipoTiempo(
        tiempoDesc = "Nebada intensa",
        iconRes = R.drawable.ic_snowy
    )
    object Tormenta: TipoTiempo(
        tiempoDesc = "Tormenta",
        iconRes = R.drawable.ic_thunder
    )
    object TormendaGranizoLigera: TipoTiempo(
        tiempoDesc = "Tormenta con granizada ligera",
        iconRes = R.drawable.ic_rainythunder
    )
    object TormentaGranizoIntensa: TipoTiempo(
        tiempoDesc = "Tormenta con granizada intensa",
        iconRes = R.drawable.ic_rainythunder
    )

    // Asocia cada tipo de tiempo meteorológico a su correspondiente código de la OMM
    companion object {
        fun codigoOMM(code: Int): TipoTiempo {
            return when(code) {
                0 -> Soleado
                1 -> MayormenteSoleado
                2 -> MayormenteNublado
                3 -> Nublado
                45 -> Niebla
                48 -> Rocio
                51 -> LloviznaLigera
                53 -> Llovizna
                55 -> LloviznaDensa
                56 -> LluviGelidaLigera
                57 -> LluviaGelidaDensa
                61 -> LluviaLigera
                63 -> Lluvia
                65 -> LluviaIntensa
                66 -> LluviGelidaLigera
                67 -> AguanieveIntesa
                71 -> NieveLigera
                73 -> Nieve
                75 -> NieveIntensa
                77 -> Granizo
                80 -> AguaceroLigero
                81 -> Aguacero
                82 -> AguaceroIntenso
                85 -> NebadaLigera
                86 -> NebadaIntensa
                95 -> Tormenta
                96 -> TormendaGranizoLigera
                99 -> TormentaGranizoIntensa
                else -> Soleado
            }
        }
    }
}