package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator{

	private static final int MINIMUM_PASSWORD_LENGTH = 5;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmaSenha", "field.required");

		Usuario usuario = (Usuario) target;
		if(usuario.getSenha().trim().length() < MINIMUM_PASSWORD_LENGTH) {
			errors.rejectValue("senha", "min.char");
		}
		if(!usuario.getSenha().equals(usuario.getConfirmaSenha())){
			errors.rejectValue("confirmaSenha", "not.equals.password");
		}
	}
	
}
