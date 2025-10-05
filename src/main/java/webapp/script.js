
function validarLogin() {
    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    if(email === "" || senha === "") {
        alert("Por favor, preencha todos os campos.");
        return false;
    }

    
    if(email !== "teste@exemplo.com" || senha !== "123456") {
        alert("Email ou senha incorretos!");
        return false;
    }

    return true; 
}

function validarCadastro() {
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    const confirmarSenha = document.getElementById('confirmarSenha').value;

    if(nome === "" || email === "" || senha === "" || confirmarSenha === "") {
        alert("Todos os campos são obrigatórios!");
        return false;
    }

    if(senha !== confirmarSenha) {
        alert("As senhas não coincidem!");
        return false;
    }

    alert("Cadastro realizado com sucesso!");
    return true; 
}
