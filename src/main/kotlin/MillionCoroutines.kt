import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

//https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html

fun main(args: Array<String>) {
    println("Running a million coroutines")

    val c = AtomicLong()

    for (i in 1..1_000_000L) {
        GlobalScope.launch {
            c.addAndGet(i)
        }
    }

    println(c)
}