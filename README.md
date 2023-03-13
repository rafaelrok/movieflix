<h2 align="center"> 
  Projeto: MovieFlix
</h2>


<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

<p align="center">
      <img alt="GitHub language count" src="https://img.shields.io/github/languages/top/rafaelrok/movieflix">
     <a href="https://github.com/movieflix/README.md/commits/master">
      <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/rafaelrok/movieflix">
     </a>
     <a href="https://github.com/rafaelrok/movieflix/blob/main/LICENSE">
      <img alt="License" src="https://img.shields.io/github/license/rafaelrok/movieflix">
     </a>  
     <a href="https://github.com/tgmarinho/README-ecoleta/stargazers">
      <img alt="Stargazers" src="https://img.shields.io/github/stars/rafaelrok/movieflix?style=social">
     </a>
     <a href="https://medium.com/@rafael">
      <img alt="medium" src="https://img.shields.io/twitter/url?label=Medium&logo=medium&style=social&url=https%3A%2F%2Fmedium.com%2F%40rafael.">
     </a>
  </p>

---
<p alt="Em progresso...">Este projeto esta progresso de desenvolvimento e melhorias constante...</p>

---
> Prejeto tem por sua vez explorar os conceitos mais profundos de uma REST API, com base em tecnologias que envolve o universo do JAVA com framework spring boot
> e suas peculiaridades, projeto envolve a seguinte solução um sistema de avaliação de filmes pontuados por IA, onde por sua vez será utilizado para fins educativo
> para de exploração de recursos que envolva a liguagem java, spring e API OpenAI, porem com evolução constante da API.

---
## Feature integração com OpenAI

Nessa ultima feature foi implementado a integração com a API OpenAI, onde por sua vez foi utilizado para fins de avaliação de filmes, conforme o exemplo abaixo
a IA analisa o sentimento do comentario a respeito do filme, e retorna uma pontuação de 0.0 a 5.0, onde 0.0 é negativo e 5.0 é positivo, porem nesse intervalo tem a variação
e nessa variação e setado no frontend o score que seria as estrelas. Frontend ainda não esta implementado.

#### Solução:
Optmizar avaliação de ususário, onde com a IA analisa o sentimento do comentario e retorna uma pontuação do sentimento.

<img src="https://res.cloudinary.com/dkar9uu7g/image/upload/v1678735091/Developer/movieflix/Screenshot_2023-03-13_161513_aoa2zt.png">

---

### Ajustes e melhorias

O projeto ainda está em desenvolvimento aqui descrevo algumas das tecnologias que compoe o projeto e as próximas atualizações serão voltadas nas seguintes
tarefas que estão desmarcadas:

- [x] Spring hateoas (Maturidade da API)
- [x] Spring Security
- [x] Spring Security OAuth2
- [x] Spring JWT
- [x] ORM
- [x] Spring Data JPA
- [x] H2
- [x] Integração com AI OpenAI
- [x] Front-end com ReactJS/Typescript
- [ ] Integração com API TMDB
- [ ] Documentação com Swagger
- [ ] JSON Serialization
- [ ] FlyWay (Versionamento DB)

---
## Pré-requisitos

O projeto tende a utilizar as seguintes tecnologias para explorar seus recursos, assim com JAVA JDK 11, spring boot 2.4.4, então seguido por essas
informações, pretendo brevemente esta atualizandop para versões atuas a fim de explorar ainda mais novos recursos.
Aqui estão os principais requisitos para conseguir clonar e utilizar o projeto local, antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você devera instalar a versão mais recente: `Java JDK 11 / Spring Boot 2.4.4 / maven`
* Devera ter instalado: `H2`
* Sistema operacional: `Windows / Linux / Mac`
* Lei a documentação do projeto `(Em desenvolvimento)`

---
## Instalando `MovieFlix`

Para Utilizar a API `MovieFlix`, após o procedimento acima, siga estas etapas:

Linux e macOS:
* Abra o terminal e utilize o `git clone git@github.com:rafaelrok/movieflix.git`

Windows:
* Abra o terminal e utilize o `git clone git@github.com:rafaelrok/movieflix.git`
---

## ☕Usando `movieflix`

Para usar `movieflix`, siga estas etapas:

```
- Após execute o projeto com sua IDEA de preferência.

- Devera criar um o aplications.properties e copiar as configurações que esta informada no
  application-example.properties e informar as configurações de seus banco H2.
  
- Depois devera acessar o site da OpenAi e criar uma conta e gerar uma chave de acesso
  para poder utilizar a API, após isso devera informar a chave de acesso no arquivo
  application.properties.

- Após só executar sua apliacação com spring-boot:run
```
Link para documentação da API [OpenAI](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request) e criar uma conta 

Adicione comandos de execução e exemplos que você acha que os usuários acharão úteis. Fornece uma referência de opções para pontos de bônus!

## Contribuindo para `movieflix`
<!---Se o seu README for longo ou se você tiver algum processo ou etapas específicas que deseja que os contribuidores sigam, considere a criação de um arquivo CONTRIBUTING.md separado--->
Para contribuir com `movieflix`, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull `review`.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## Desenvolvedor
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/8467131?v=4" width="100px;" alt="Foto do Rafael Vieira no GitHub"/><br>
        <sub>
          <b>Rafael Vieira</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
<table>
  <tr>
    <a href="https://www.linkedin.com/in/rafaelvieira-s/">
      <img alt="linkedin" src="https://img.shields.io/twitter/url?label=Linkedin&logo=linkedin&style=social&url=https%3A%2F%2Fwww.linkedin.com%2Fin%2Frafaelvieira-s%2F">
    </a>
    <a href="https://medium.com/@rafael">
      <img alt="medium" src="https://img.shields.io/twitter/url?label=Medium&logo=medium&style=social&url=https%3A%2F%2Fmedium.com%2F%40rafael.">
    </a>
    <a href = "mailto:rafaelrok25@gmail.com">
      <img alt="gmail" src="https://img.shields.io/twitter/url?label=gmail&logo=gmail&style=social&url=https%3A%2F%2Fmail.google.com%2F">
    </a>
  </tr>
</table>


## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.

##  Versões do README

[Português 🇧🇷](./README.md)  |  [Inglês 🇺🇸](./README-en.md)

[⬆ Voltar ao topo](#movieflix)<br>
