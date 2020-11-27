import dsl.*

fun main() {
    val compiled = brainfck {
        add(10)

        loop {
            right()
            add(7)

            right()
            add(10)

            right()
            add(3)

            right()
            add(1)

            left(4)
            sub()
        }

        // H
        right()
        add(2)
        put()

        // e
        right()
        add()
        put()

        // ll
        add(7)
        put()
        put()

        // o
        add(3)
        put()

        // " "
        right()
        add(2)
        put()

        // W
        left()
        left()
        add(15)
        put()

        // o
        right()
        put()

        // r
        add(3)
        put()

        // l
        sub(6)
        put()

        // d
        sub(8)
        put()

        // !
        right()
        add()
        put()

        // \n
        right()
        put()
    }
    println(compiled.toString())

    val reference = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
    println(reference)

    println(compiled.toString() == reference)
}