package io.github.atmaramnaik.kosel

import org.openqa.selenium.SearchContext
import java.util.function.Function

interface SearchContextExpectedCondition<T> : Function<SearchContext, T>