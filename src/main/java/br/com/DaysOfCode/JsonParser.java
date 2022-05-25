package br.com.DaysOfCode;

import java.util.List;

public interface JsonParser {
    List<? extends Content> parse();
}