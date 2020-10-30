import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html

fun main(args: Array<String>) {
    println("Running with Suspending Functions")

    val sumFun = (1..1_000_000).map { n ->
        GlobalScope.async {
            workload(n)
        }
    }

    runBlocking {
        val sum = sumFun.map { it.await().toLong() }.sum()
        println(sum)
    }
}

suspend fun workload(int: Int) : Int {
    delay(1000)
    return int
}