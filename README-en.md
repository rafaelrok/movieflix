<h2 align="center">
   Project: MovieFlix
</h2>


<!---These are examples. See https://shields.io for others or to customize this shield set. You may want to include dependencies, project status and license information here--->

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
<p alt="In progress...">This project is in constant development and improvement progress...</p>

---
> Project has in turn to explore the deeper concepts of a REST API, based on technologies that involve the universe of JAVA with spring boot framework
> and its peculiarities, the project involves the following solution: a system for evaluating films scored by AI, which in turn will be used for educational purposes
> for resource exploration involving the java language, spring and OpenAI API, but with constant evolution of the API.

---
## Feature integration with OpenAI

In this last feature, integration with the OpenAI API was implemented, which in turn was used for movie evaluation purposes, as shown in the example below.
the AI analyzes the sentiment of the comment about the film, and returns a score from 0.0 to 5.0, where 0.0 is negative and 5.0 is positive, but in this range there is the variation
and in this variation, the score that would be the stars is set in the frontend. Frontend is not yet implemented.

#### Solution:
Optimize User Rating, where AI analyzes comment sentiment and returns a sentiment score.

<img src="https://res.cloudinary.com/dkar9uu7g/image/upload/v1678735091/Developer/movieflix/Screenshot_2023-03-13_161513_aoa2zt.png">

---

### Tweaks and improvements

The project is still under development here I describe some of the technologies that make up the project and the next updates will be focused on the following
tasks that are unchecked:

- [x] Spring hateoas (API Maturity)
  - [x]Spring Security
- [x] Spring Security OAuth2
- [x] Spring JWT
- [x] ORM
- [x] Spring Data JPA
- [x] H2
- [x] Integration with AI OpenAI
- [x] Front-end with ReactJS/Typescript
- [ ] Integration with TMDB API
- [ ] Documentation with Swagger
- [ ] JSON Serialization
- [ ] FlyWay (DB Versioning)

---
## Prerequisites

The project tends to use the following technologies to exploit its features, such as JAVA JDK 11, spring boot 2.4.4, then followed by these
information, I intend to briefly update to current versions in order to explore even more new features.
Here are the main requirements to be able to clone and use the local project, before starting, make sure you have met the following requirements:
<!---These are example requirements only. Add, duplicate or remove as needed--->
* You should install the latest version: `Java JDK 11 / Spring Boot 2.4.4 / maven`
* Should have installed: `H2`
* Operating system: `Windows / Linux / Mac`
* Read the project documentation `(In development)`

---
## Installing `MovieFlix`

To Use the `MovieFlix` API, after the above procedure, follow these steps:

Linux and macOS:
* Open the terminal and use `git clone git@github.com:rafaelrok/movieflix.git`

Windows:
* Open the terminal and use `git clone git@github.com:rafaelrok/movieflix.git`
---

## ☕Using `movieflix`

To use `movieflix`, follow these steps:

```
- After executing the project with your preferred IDEA.

- You should create an aplications.properties and copy the settings that are informed in the
   application-example.properties and inform your H2 database settings.
  
- Then you must access the OpenAi website and create an account and generate an access key
   to be able to use the API, after that you must inform the access key in the file
   application.properties.

- After just running your application with spring-boot:run
```
Link to API documentation [OpenAI](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request) and create an account

Add run commands and examples that you think users will find useful. Provides an options reference for bonus points!

## Contributing to `movieflix`
<!---If your README is long or if you have any specific process or steps you want contributors to follow, consider creating a separate CONTRIBUTING.md file--->
To contribute to `movieflix`, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to original branch: `git push origin <project_name> / <location>`
5. Create the `review` pull request.

Alternatively, see the GitHub documentation at [how to create a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request ).

## Developer
<table>
   <tr>
     <td align="center">
       <a href="#">
         <img src="https://avatars.githubusercontent.com/u/8467131?v=4" width="100px;" alt="Photo by Rafael Vieira on GitHub"/><br>
         <sub>
           <b>Rafael Vieira</b>
         </sub>
       </a>
     </all>
   </tr>
</table>
<table>
   <tr>
     <a href="https://www.linkedin.com/in/rafaelvieira-s/">
       <img alt="linkedin" src="https://img.shields.io/twitter/url?label=Linkedin&logo=linkedin&style=social&url=https%3A%2F%2Fwww.linkedin.com%2Fin%2Frafaelvieira-s% 2F">
     </a>
     <a href="https://medium.com/@rafael">
       <img alt="medium" src="https://img.shields.io/twitter/url?label=Medium&logo=medium&style=social&url=https%3A%2F%2Fmedium.com%2F%40rafael.">
     </a>
     <a href="mailto:rafaelrok25@gmail.com">
       <img alt="gmail" src="https://img.shields.io/twitter/url?label=gmail&logo=gmail&style=social&url=https%3A%2F%2Fmail.google.com%2F">
     </a>
   </tr>
</table>


## 📝 License

This project is under license. See the [LICENSE](LICENSE.md) file for more details.

## README versions

[Portuguese br](./README.md) | [English 🇺🇸](./README-en.md)

[⬆ back to top](#movieflix)<br>