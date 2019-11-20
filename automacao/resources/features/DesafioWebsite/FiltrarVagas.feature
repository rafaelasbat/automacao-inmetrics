#language: pt
#version: 1.0
#author: Rafaela Batista
@Vagas
Funcionalidade: Filtrar Vagas

  Contexto: Dado que acessei a tela de Vagas da Inmetrics
  
  @CT1
  Cenario: CN01CT01 - Filtrar Vagas por Tipo de Vaga
    Dado que estou na tela de Vagas da Inmetrics
    Quando selecionar o tipo de vaga
    Entao o sistema ira carregar as vagas de acordo com o tipo selecionado

  @CT02
  Cenario: CN01CT02 - Filtrar Vagas por Local de trabalho
    Dado que estou na tela de Vagas da Inmetrics
    Quando selecionar o local de trabalho
    Entao o sistema ira carregar as vagas de acordo com o local selecionado
    
  @CT03
  Cenario: CN01CT03 - Filtrar Vagas por Área
    Dado que estou na tela de Vagas da Inmetrics
    Quando selecionar a area
    Entao o sistema ira carregar as vagas de acordo com a area selecionada
