package com.example.heroapp

data class Pergunta(
    val id: Int,
    val textoDaPergunta: String,
    val opcoes: List<Opcao>,    // Ex: ["Opção A", "Opção B", "Opção C"]
)

data class Opcao(
    val texto: String,
    val heroiIds: List<Int>,
    val imagem: Int
)

data class Heroi(
    val id: Int,
    val nome: String,
    val imagemHeroi: Int
)
