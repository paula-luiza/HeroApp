package com.example.heroapp

class LogicaQuiz {

    val herois = listOf(
        Heroi(1, "Superman", R.drawable.superman),
        Heroi(2, "Batman", R.drawable.batman),
        Heroi(3, "Iron Man", R.drawable.ironman),
        Heroi(4, "Mulher Maravilha", R.drawable.wonderwoman),
        Heroi(5, "Homem Aranha", R.drawable.spidey)
    )

    private val bancoDePerguntas = listOf(
        Pergunta(
            1,
            "Qual sua comida favorita?",
            opcoes = listOf(
                Opcao("Churrasco", listOf(1)),
                Opcao("Massa", listOf(2)),
                Opcao("Salada", listOf(3)),
                Opcao("Japonês", listOf(4))
            )
        ),
        Pergunta(
            2,
            "Qual sua comida favorita?",
            opcoes = listOf(
                Opcao("Churrasco", listOf(3)),
                Opcao("Massa", listOf(5)),
                Opcao("Salada", listOf(2)),
                Opcao("Japonês", listOf(4))
            )
        )
    )

    fun criarPlacarInicial(): IntArray {
        return IntArray(herois.size) // Retorna um novo [0, 0, 0]
    }

    fun registrarResposta(pontuacaoHerois: IntArray, heroiIds: List<Int>) {
        for (id in heroiIds) {
            pontuacaoHerois[id]++
        }
    }

    fun getPergunta(id: Int): Pergunta {
        return bancoDePerguntas[id]
    }

    fun getPontuacaoCompleta(pontuacaoHerois: IntArray): IntArray {
        return pontuacaoHerois
    }

    fun getResultadoFinal(pontuacaoHerois: IntArray): Heroi {
        val idVencedor = pontuacaoHerois.maxByOrNull { pontuacaoHerois[it] } ?: 0
        return herois[idVencedor]
    }
}