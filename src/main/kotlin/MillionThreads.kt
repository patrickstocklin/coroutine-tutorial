import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

//https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html

fun main(args: Array<String>) {
    println("Running a million threads")

    val c = AtomicLong()

    for (i in 1..1_000_000L) {
        thread(start = true) {
            println("Adding and getting $i")
            c.addAndGet(i)
        }
    }

    println(c)
}