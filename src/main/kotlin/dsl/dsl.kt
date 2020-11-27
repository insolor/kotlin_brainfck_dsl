package dsl

fun brainfck(func: ProgramContext.() -> Unit): ProgramContext {
    return ProgramContext().apply(func)
}

class ProgramContext {
    val commands: ArrayList<String> = ArrayList()

    override fun toString(): String {
        return commands.joinToString(separator = "")
    }
}

fun ProgramContext.add(i: Int = 1) {
    commands.add("+".repeat(i))
}

fun ProgramContext.sub(i: Int = 1) {
    commands.add("-".repeat(i))
}

fun ProgramContext.left(i: Int = 1) {
    commands.add("<".repeat(i))
}

fun ProgramContext.right(i: Int = 1) {
    commands.add(">".repeat(i))
}

fun ProgramContext.put() {
    commands.add(".")
}

fun ProgramContext.get() {
    commands.add(",")
}

fun ProgramContext.loop(func: ProgramContext.() -> Unit) {
    val context = ProgramContext()
    commands.add("[")
    commands.add(context.apply(func).toString())
    commands.add("]")
}