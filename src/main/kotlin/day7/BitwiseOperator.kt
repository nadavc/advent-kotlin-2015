package day7

import java.util.*


class BitwiseOperator(inst: List<String>) {

    private val instructions = inst
    private val state = HashMap<String, Int>()

    // number -> x
    // a OPERATOR b -> x (where a and/or b can be numbers)
    // NOT c -> x (c can be a number)

    private val simpleWireRegex = "([a-z]+|[0-9]+) -> ([a-z]+)".toRegex()
    private val binaryOpRegex = "([a-z]+|[0-9]+) ([A-Z]+) ([a-z]+|[0-9]+) -> ([a-z]+)".toRegex()
    private val notOpRegex = "NOT ([a-z]+|[0-9]+) -> ([a-z]+)".toRegex()

    private val stateRegex = "[a-z]+".toRegex()


    fun valueOrValueOfState(key: String): Int {
        return if (stateRegex.matches(key)) {
            state.getOrDefault(key, 0)
        } else {
            key.toInt()
        }
    }

    fun Regex.toRegexComponents(s: String): List<String> = this.matchEntire(s)!!.groupValues

    fun Int.truncTo16Bits(): Int {
        return this and 0x0000FFFF
    }

    fun process(): Map<String, Int> {
        for (inst in instructions) {
            when {
                simpleWireRegex.matches(inst) -> {
                    val (ignored, value, target) = simpleWireRegex.toRegexComponents(inst)
                    state.put(target, valueOrValueOfState(value).truncTo16Bits())
                }
                binaryOpRegex.matches(inst) -> {
                    val arr = binaryOpRegex.toRegexComponents(inst)
                    val lhs = valueOrValueOfState(arr[1])
                    val operator = arr[2]
                    val rhs = valueOrValueOfState(arr[3])
                    val target = arr[4]
                    val result = when (operator) {
                        "AND" -> (lhs and rhs)
                        "LSHIFT" -> (lhs shl rhs)
                        "RSHIFT" -> (lhs shr rhs)
                        "OR" -> (lhs or rhs)
                        else -> throw RuntimeException("Unable to process $operator")
                    }
                    state.put(target, result.truncTo16Bits())
                }
                notOpRegex.matches(inst) -> {
                    val arr = notOpRegex.toRegexComponents(inst)
                    val lhs = valueOrValueOfState(arr[1])
                    val target = arr[2]
                    state.put(target, lhs.inv().truncTo16Bits())
                }
                else -> println("Unexpected format: $inst")
            }
        }
        return state
    }


}
