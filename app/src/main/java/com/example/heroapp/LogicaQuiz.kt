package com.example.heroapp

class LogicaQuiz {

    val herois = listOf(
        Heroi(1, "Superman", R.drawable.superman),
        Heroi(2, "Batman", R.drawable.batman),
        Heroi(3, "Iron Man", R.drawable.ironman),
        Heroi(4, "Mulher Maravilha", R.drawable.wonderwoman),
        Heroi(5, "Homem Aranha", R.drawable.spidey),
        Heroi(6, "Jean Grey", R.drawable.jean),
        Heroi(7, "Loki", R.drawable.loki),
        Heroi(8, "Thor", R.drawable.thor)
    )

    private val bancoDePerguntas = listOf(
        Pergunta(
            1,
            "Que tipo de atração em parque de diversão você prefere?",
            opcoes = listOf(
                Opcao("Montanha-russa", listOf(3, 8), R.drawable.hulk), // Iron Man (velocidade, adrenalina), Thor (poder, "show-off")
                Opcao("Casa mal-assombrada.", listOf(2, 7), R.drawable.haunted), // Batman (sombrio), Loki (trapaça, ilusão)
                Opcao("Simulador de voo", listOf(1, 4), R.drawable.soarin), // Superman (voo), Mulher Maravilha (voo)
                Opcao("Sling Shot", listOf(5, 6), R.drawable.slingshot)  // Homem Aranha (agilidade), Jean Grey (poder telecinético)
            )
        ),

        Pergunta(
            2,
            "Se você fosse um treinador, qual tipo de Pokémon seria seu ás?",
            opcoes = listOf(
                Opcao("Psíquico (ex: Alakazam, Mewtwo).", listOf(6, 7), R.drawable.alakazam), // Jean Grey (telepata), Loki (mágico/ilusionista)
                Opcao("Elétrico (ex: Zapdos, Pikachu).", listOf(8, 5), R.drawable.eletrico), // Thor (raios), Homem Aranha (energia/agilidade)
                Opcao("Aço (ex: Metagross, Scizor).", listOf(3, 2), R.drawable.aco), // Iron Man (armadura), Batman (armadura/ferramentas)
                Opcao("Lutador (ex: Machamp, Lucario).", listOf(1, 4), R.drawable.lutador)  // Superman (força), Mulher Maravilha (guerreira)
            )
        ),

        Pergunta(
            3,
            "Qual seu gênero de jogo favorito?",
            opcoes = listOf(
                Opcao("RPG de fantasia com mundos épicos", listOf(4, 8), R.drawable.rpg), // Mulher Maravilha (mitologia), Thor (mitologia)
                Opcao("Jogos de estratégia complexos", listOf(2, 3), R.drawable.civ6), // Batman (tático), Iron Man (gênio estrategista)
                Opcao("Jogos de plataforma e agilidade", listOf(5, 7), R.drawable.mario), // Homem Aranha (agilidade), Loki (ágil, trapaceiro)
                Opcao("Jogos 'sandbox' onde você pode criar tudo", listOf(1, 6),R.drawable.minecraft)  // Superman (poder total), Jean Grey (poder de criar/mudar)
            )
        ),
        Pergunta(
            4,
            "Que tipo de filme (que não seja de herói) você escolhe para ver?",
            opcoes = listOf(
                Opcao("Ficção Científica complexa", listOf(3, 6), R.drawable.dune), // Iron Man (tecnologia, futuro), Jean Grey (poderes cósmicos)
                Opcao("Um filme clássico inspirador", listOf(1, 4), R.drawable.sociedade), // Superman (esperança), Mulher Maravilha (compaixão)
                Opcao("Suspense investigativo", listOf(2, 5), R.drawable.seven), // Batman (detetive), Homem Aranha (investigativo)
                Opcao("Uma fantasia épica com magia", listOf(7, 8), R.drawable.lotr)  // Loki (magia), Thor (mitologia)
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