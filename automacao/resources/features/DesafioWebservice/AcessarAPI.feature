#language: pt
#version: 1.0
#author: Rafaela Batista
@API
Funcionalidade: GET em API

  @CT01
  Cenario: CN01CT01 - Validar resposta do serviço
    Dado que acesso a API de filmes
    Quando envio o GET
    Entao e retornado o titulo de todos os filmes

  @CT02
  Cenario: CN01CT02 - Validar filtro por diretor e produtor
    Dado que acesso a API de filmes
    Quando envio o GET
    Entao e retornado os filmes de George Lucas e Rick McCallum
