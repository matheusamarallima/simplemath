package br.com;


import br.com.exception.UnsupportedMathOp;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";

	@RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum = ((convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2);
		return sum;
	}

	@RequestMapping(value = "exp/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double exp(
			@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOp("Please, set a numeric value");

		}
		double sum1 = (convertToDouble(numberOne) + convertToDouble(numberTwo));
		double sum2 = Math.sqrt(sum1);
		return sum2;
	}



	private double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
