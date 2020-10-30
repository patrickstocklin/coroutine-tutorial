import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html

fun main(args: Array<String>) {
    println("Running coroutines with a Deferred object returned from async")

    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
            println(n)
            delay(1000L) //proves we run coroutines in parallel, else this would take days
            n
        }
    }

    runBlocking {
        val sum = deferred.map { it.await().toLong() }.sum()
        println(sum)
    }

}