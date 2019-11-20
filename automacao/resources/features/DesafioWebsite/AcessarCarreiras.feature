#language: pt
#version: 1.0
#author: Rafaela Batista
@Carreiras
Funcionalidade: Acessar a tela de Carreiras

  @CT01
  Cenario: CN01CT01 - Acessar tela de Carreiras
    Dado que estou na pagina inicial da Inmetrics
    Quando clicar em Carreiras
    Entao o sistema deve apresentar o botao Confira nossas vagas

  @CT02
  Cenario: CN01CT02 - Acessar tela de Vagas
    Dado que estou na pagina inicial da Inmetrics
    Quando clicar em Carreiras
    E clicar em Confira nossas vagas
    Entao o sistema deve encaminhar para a tela de vagas
