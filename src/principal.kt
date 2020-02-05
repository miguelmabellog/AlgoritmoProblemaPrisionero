fun main(args: Array<String>){
    println("Numero de barrotes horizontales")
    var m: Int = readLine()?.toInt() as Int
    println("Numero de barrotes verticales")
    var n: Int = readLine()?.toInt() as Int
    println("Numero barrotes horizontales que se quitan")
    var h: Int = readLine()?.toInt() as Int
    println("Numero barrotes verticales que se quitan")
    var v: Int = readLine()?.toInt() as Int
    println("Cuales barrotes horizontales se quitan")
    var listh= mutableListOf<Int>()
    for(i in 0 until h){
        listh.add(readLine()?.toInt() as Int)
    }

    println("Cuales barrotes verticlaes se quitan")
    var listv= mutableListOf<Int>()
    for(i in 0 until v){
        listv.add(readLine()?.toInt() as Int)
    }

    CalculaArea(m,n,h,v,listh,listv)
}

fun CalculaArea(
    numeroM: Int,
    numeroN: Int,
    numeroh: Int,
    numerov: Int,
    listh: MutableList<Int>,
    listv: MutableList<Int>
){
    println("solución")

    for(i in listh.indices){       // ordeno los barrotes que se quitan horizontalmente de menor a mayor
        for(ii in listh.indices){
            if(listh[i]<listh[ii]&&(i!=ii)){
                val x=listh[i]
                listh[i]=listh[ii]
                listh[ii]=x
            }
        }
    }
    for(i in listv.indices){       // ordeno los barrotes que se quitan verticalmente de menor a mayor
        for(ii in listv.indices){
            if(listv[i]<listv[ii]&&(i!=ii)){
                val x=listv[i]
                listv[i]=listv[ii]
                listv[ii]=x
            }
        }
    }
    // de los intervalos de barrotes horizontales que son seguidos, tomo el comienzo del intervalo
    var finalh= mutableListOf<Int>()
    var comienzoh= mutableListOf<Int>()
    for(i in listh.indices){
        if(i==0 && listh[i+1]-listh[i]==1){
            comienzoh.add(listh[i])
        }else {
            if (i != listh.size - 1 && listh[i + 1] - listh[i] == 1 && listh[i] - listh[i - 1] != 1) {
                comienzoh.add(listh[i])
            }
        }

        // de los intervalos de numeros que son seguidos, tomo el final del intervalo

        if(i!= listh.size-1){
            if(i!=0 && listh[i]-listh[i-1]==1 && listh[i+1]-listh[i]!=1 ){
                finalh.add(listh[i])
            }

        }else {
            if (i == listh.size-1 && listh[i] - listh[i-1] == 1) {
                finalh.add(listh[i])
            }
        }

    }

    var resultadoh= mutableListOf<Int>()
    var x=0
    for(i in finalh.indices){
        resultadoh.add(finalh[i]-comienzoh[i])

        if(i!=0&&resultadoh[i]>resultadoh[i-1]){
            x=resultadoh[i]
        }else{
            if(i==0){
                x=resultadoh[i]
            }
        }

    }
    println("barrotes horizontales: $listh")
    println("barrotes de comienzo $comienzoh")
    println("barrotes de final $finalh")
    println(x)
    // de los intervalos de barrotes verticales que son seguidos, tomo el comienzo del intervalo
    var finalv= mutableListOf<Int>()
    var comienzov= mutableListOf<Int>()
    for(i in listv.indices){
        if(i==0 && listv[i+1]-listv[i]==1){
            comienzov.add(listv[i])
        }else {
            if (i != listv.size - 1 && listv[i + 1] - listv[i] == 1 && listv[i] - listv[i - 1] != 1) {
                comienzov.add(listv[i])
            }
        }

        // de los intervalos de numeros que son seguidos, tomo el final del intervalo

        if(i!= listv.size-1){
            if(i!=0 && listv[i]-listv[i-1]==1 && listv[i+1]-listv[i]!=1 ){
                finalv.add(listv[i])
            }

        }else {
            if (i == listv.size-1 && listv[i] - listv[i-1] == 1) {
                finalv.add(listv[i])
            }
        }

    }

    var resultadov= mutableListOf<Int>()
    var y=0
    for(i in finalv.indices){
        resultadov.add(finalv[i]-comienzov[i])

        if(i!=0&&resultadov[i]>resultadov[i-1]){
            y=resultadov[i]
        }else{
            if(i==0){
                y=resultadov[i]
            }
        }

    }

    println("barrotes verticales: $listv")
    println("barrotes de comienzov $comienzov")
    println("barrotes de finalv $finalv")
    println("Nuemero mas grande de barrotes verticales seguidos $y")




}