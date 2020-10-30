import kotlinx.coroutines.*

//https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html

fun main(args: Array<String>) {
    println("Starting a Coroutine")

    GlobalScope.launch {
        delay(3000)
        println("Hello World")
    }

    runBlocking {   //Blocks thread interruptibly until it is completed
        delay(3000)
        println("RunBlocking complete")
    }

    Thread.sleep(4000)
    println("Stopping")
}