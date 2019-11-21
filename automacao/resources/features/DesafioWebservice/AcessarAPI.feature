#language: pt
#version: 1.0
#author: Rafaela Batista

@API
Funcionalidade: GET em API 

  @CT1
  Cenario: CN01CT01 - Validar resposta do servi�o 
    Dado que acesso a API de filmes
    Quando envio o GET
    Entao � retornado o t�tulo de todos os filmes

  @CT02
  Cenario: CN01CT02 - Validar o status code da resposta do servi�o
    Dado que acesso a API de filmes
    Quando envio o GET
    Entao o status code da resposta � 200
