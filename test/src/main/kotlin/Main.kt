fun main(args: Array<String>) {

    printMenu()
    var userResponse = getUserInput()

    while (userResponse != 4) {
        if (userResponse == 1) {
            var ingredients = arrayListOf<Ingredient>()
            var directions = arrayListOf<Direction>()

            print("Recipe name: ")
            var name = readLine()
            print("Description: ")
            var description = readLine()
            println("Now start listing the ingredients")
            var userAnswer = "y"
            while (userAnswer == "y") {
                print("Ingredient name: ")
                var ingredientName = readLine()
                print("Unit of measurement: ")
                var unitOfMeasurement = readLine()
                print("Quantity: ")
                var quantityString = readLine()
                var quantity = quantityString?.toDouble()
                // create object of ingredient and pass in name, quantity, unit of measurement
                val ingredient = Ingredient(ingredientName, quantity, unitOfMeasurement)
                ingredients.add(ingredient)

                println("Next ingredient? (y/n)")
                userAnswer = readLine().toString()
            }
            println("Start listing the directions, separated by step")
            var i = 1
            userAnswer = "y"
            while (userAnswer == "y") {
                print("Step ${i}: ")
                var step = readLine()
                var stepNum = i
                var direction = Direction(step, stepNum)
                directions.add(direction)
                i++
                println("Next step? (y/n)")
                userAnswer = readLine().toString()
            }
            var recipe = Recipe(name, description, ingredients, directions)

            print("Do you want to view the recipe? (y/n) ")
            userAnswer = readLine().toString()
            if (userAnswer == "y") {
                recipe.printRecipe()
            }
            println()
        }
        else if (userResponse == 2) {
            println("You chose option 2")
        }
        else if (userResponse == 3) {
            println("You chose option 3")
        }
        else {
            println("That's an incorrect input. Please try again")
        }
        printMenu()
        userResponse = getUserInput()
     }

}

class Recipe constructor(var name: String?, var description: String?, var ingredients: ArrayList<Ingredient>, var directions: ArrayList<Direction>) {

//    init {
//        var recipeName = name?.uppercase()
//        var description = description
//        var ingredients = ingredients
//        var directions = directions
//    }

    fun printRecipe() {
        println()
        println("Name: ${name}")
        println("Description: ${description}")
        println("Ingredients: ")
        ingredients.forEach {ingredient -> println("- ${ingredient.quantity} ${ingredient.unitOfMeasurement}  ${ingredient.name}")
        }
        println("Directions: ")
        directions.forEach {direction -> println("${direction.stepNum}. ${direction.step}")}
    }
    // methods
        // display recipe
        // edit recipe
        // add critique
        // add review
        // display reviews
        // delete recipe
        // add ingredients to list
//    fun getIngredients (vararg ingredient) {


}

class Ingredient(var name: String?, var quantity: Double?, var unitOfMeasurement: String?) {
//    init {
//        var ingredientName = name?.uppercase()
//        var quantity = quantity
//        var unitOfMeasurement = unitOfMeasurement
//    }

    // var allergenType = ""
    // substitutionOption = list of strings

    // methods
        // change quantity (number of recipes)
        // display possible substitution
}
class Direction constructor(var step: String?, var stepNum: Int) {}

fun printMenu () {
    println("Which option do you want to do? ")
    println("1) Add new recipe")
    println("2) Edit previous recipe")
    println("3) Select recipe")
    println("4) Quit")
}

fun getUserInput() : Int? {
    var userResponseString = readLine()
    var userResponse = userResponseString?.toInt()
    return userResponse
}