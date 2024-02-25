enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int)

data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>,
    val nivel: Nivel
) {
    val inscritos = mutableSetOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
    }
}

fun main() {
    val usuario1 = Usuario("Murilo")
    val usuario2 = Usuario("João")

    val conteudoGit = ConteudoEducacional("cursoGit", Nivel.BASICO, 60)
    val conteudoKt = ConteudoEducacional("cursoKotlin", Nivel.INTERMEDIARIO, 60)

    val formacao = Formacao("Kotlin", listOf(conteudoKt, conteudoGit), Nivel.AVANCADO)
    formacao.matricular(usuario1, usuario2)
    
    //println(usuario1)
    //println(usuario2)
    //println(conteudoGit)
    //println(conteudoKt)
    //println(formacao)
    println("Usuários inscritos na formação ${formacao.nome}: ${formacao.inscritos}")
}