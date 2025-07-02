package br.com.study.controller;

import static br.com.study.utils.NumberConverter.convertToDouble;
import static br.com.study.utils.NumberConverter.isNumeric;

import br.com.study.exception.UnsupportedMathOperationException;
import br.com.study.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

  private SimpleMath math = new SimpleMath();

  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo
  ){

    if(!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("\"Please set a numeric values!\"");

    return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
  }

  @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
  public Double subtraction(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo
  ){

    if(!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric values!");

    return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
  }
}
