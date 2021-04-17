import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    CalculatorWork.declareStatement(CalculatorWork.strHeading)
    CalculatorWork.declareStatement(CalculatorWork.strAskOp)
    var scanner = Scanner(System.`in`)
    var opInput = scanner.next()
    CalculatorWork.declareStatement("Enter the first value")
    var firstScanned = scanner.nextFloat()
    CalculatorWork.declareStatement("Enter the second value")
    var secondScanned = scanner.nextFloat()
    var calObj = CalculatorWork(firstScanned, secondScanned, opInput)
    calObj.particularProcess()

}

class CalculatorWork {

    var firstVar: Float = 0f
    var secondVar: Float = 0f
    var operation: String = ""
    var result: Float = 0f


    constructor(first: Float, second: Float, str: String) {
        firstVar = first
        secondVar = second
        operation = str
    }

    companion object {
        val strHeading = "\n------------\n CALCULATOR \n------------\n"
        val strAskOp =
            "Which operation you would like to perform? \n + :Additon \n - :Subtraction \n * :Multiplicaton \n / :Division \n % :Modulation \n ~ :SquareRoot \n ^ :Power \n ! :Factorial\n\n Please enter the corresponding sign of the operation"
        val strResult = "Result : "

        //    declare statement
        fun declareStatement(strStatement: String) {
            println(strStatement)
        }

    }


    //    addition process
    fun addition() {
        result = firstVar.plus(secondVar)
        declareStatement(strResult + result)
    }

    //   subtraction process
    fun subtraction() {
        result = when {
            firstVar > secondVar -> {
                firstVar.minus(secondVar)
            }
            else -> {
                secondVar.minus(firstVar)
            }
        }
        declareStatement(strResult + result)
    }

    //    multiplication process
    fun multiplication() {
        result = firstVar.times(secondVar)
        declareStatement(strResult + result)
    }

    //    division process
    fun division() {
        when {
            secondVar == 0f -> {
                declareStatement("Denominator cant be zero")
                return
            }
            else -> {
                result = firstVar.div(secondVar)
            }
        }
        declareStatement(strResult + result)
    }

    //    mod process
    fun modProcess() {
        when {
            secondVar == 0f -> {
                declareStatement("Denominator cant be zero")
                return
            }
            else -> {
                result = firstVar.rem(secondVar)
            }
        }
        declareStatement(strResult + result)
    }

    //    power process
    fun powerProcess() {
        result = firstVar.pow(secondVar)
        declareStatement(strResult + result)
    }

    //    factorial process
    fun factorialProcess() {
        if (!checkIfWhole(firstVar, secondVar)) {
            declareStatement("Please enter the whole no, because factorial is taken of whole no")
            return
        }

        var factorial: Long = 1
        for (i in 1..firstVar.toLong()) {
            factorial *= i.toLong()
        }

        var factorial2: Long = 1
        for (i in 1..secondVar.toLong()) {
            factorial2 *= i.toLong()
        }
        declareStatement("Result for 1st value = $factorial")
        declareStatement("Result for 2nd value = $factorial2")


    }


    fun squareRoot() {
        result = sqrt(firstVar.toDouble()).toFloat()
        declareStatement("Result for 1st value = $result")
        result = sqrt(secondVar.toDouble()).toFloat()
        declareStatement("Result for 2nd value = $result")

    }

    fun checkIfWhole(first: Float, second: Float): Boolean {
        var isFirstWhole = first % 1
        var isSecondWhole = second % 1
        return isFirstWhole == 0f && isSecondWhole == 0f
    }


    fun particularProcess() {
        when (operation.trim()) {
            "+" -> addition()
            "-" -> subtraction()
            "*" -> multiplication()
            "/" -> division()
            "%" -> modProcess()
            "~" -> squareRoot()
            "^" -> powerProcess()
            "!" -> factorialProcess()

            else -> declareStatement("Please enter the correct operator")
        }
    }
}

