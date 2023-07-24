package modulos.produto;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Testes de API Rest do modulo de Produto")
public class ProdutoTest_1 {
    @Test
    @DisplayName("Validar os limites proibidos do valor do produto")
    public void testVal

    idarLimitesProibidoValorProduto(){
     //Configurando os dados da API Rest da Lojinha
       baseURI = "http://165.227.93.41";
       //port = 8080;
        basePath = "/lojinha";

     //Obter o token do usuario admin
        String token = given()
            .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioLogin\": \"admin\",\n" +
                        "  \"usuarioSenha\": \"admin\"\n" +
                        "}")
                .when()
                    .post("/v2/login")
                .then()
                .extract()
                    .path(" data.token");

       // System.out.println(token);

     //Tentar incluir um produto com valor 0.00 e validar que a mensagem de erro foi apresentado e o
     // status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body("{\n" +
                        "  \"produtoNome\": \"Play Station da Automacao 5\",\n" +
                        "  \"produtoValor\": 0.00,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle da Automacao\",\n" +
                        "      \"componenteQuantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")

                .when()
                    .post("/v2/produtos")
                .then()
                    .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }

   /* public void testValidarLimitesProibidoValorProduto(){
        double valor = 0.1;
        Assertions.assertTrue(valor > 0.00);
    }*/
}
