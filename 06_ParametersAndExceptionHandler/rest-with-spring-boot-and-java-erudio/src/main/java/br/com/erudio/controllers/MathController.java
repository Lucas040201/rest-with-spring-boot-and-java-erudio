package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.shared.exceptions.UnsupportedMathOperationException;
import br.com.erudio.shared.services.NumberConverterService;
import br.com.erudio.shared.services.SimpleMathService;

@RestController
public class MathController {

	private static AtomicLong counter = new AtomicLong();
	private NumberConverterService numberConverterService = new NumberConverterService();
	private SimpleMathService simpleMathService = new SimpleMathService();
	
	@RequestMapping(
		value = "/sum/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
	)
	public Double sum(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!this.numberConverterService.isNumeric(numberOne) || !this.numberConverterService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.sum(this.numberConverterService.convertToDouble(numberOne), this.numberConverterService.convertToDouble(numberTwo));
	}

	@RequestMapping(
		value = "/subtraction/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
	)
	public Double subtraction(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!this.numberConverterService.isNumeric(numberOne) || !this.numberConverterService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.subtraction(this.numberConverterService.convertToDouble(numberOne), this.numberConverterService.convertToDouble(numberTwo));
	}

	
	@RequestMapping(
		value = "/division/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
	)
	public Double division(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!this.numberConverterService.isNumeric(numberOne) || !this.numberConverterService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.division(this.numberConverterService.convertToDouble(numberOne), this.numberConverterService.convertToDouble(numberTwo));
	}

	@RequestMapping(
		value = "/multiplication/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
	)
	public Double multiplication(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!this.numberConverterService.isNumeric(numberOne) || !this.numberConverterService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.multiplication(this.numberConverterService.convertToDouble(numberOne), this.numberConverterService.convertToDouble(numberTwo));
	}

	@RequestMapping(
		value = "/squareRoot/{number}",
		method = RequestMethod.GET
	)
	public Double squareRoot(
		@PathVariable(value = "number") String number
	) throws Exception {
		if(!this.numberConverterService.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.squareRoot(this.numberConverterService.convertToDouble(number));
	}

	@RequestMapping(
		value = "/mean/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
	)
	public Double mean(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception {
		if(!this.numberConverterService.isNumeric(numberOne) || !this.numberConverterService.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return this.simpleMathService.mean(this.numberConverterService.convertToDouble(numberOne), this.numberConverterService.convertToDouble(numberTwo));
	}

}
