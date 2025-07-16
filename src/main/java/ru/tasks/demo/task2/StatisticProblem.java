package ru.tasks.demo.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Необходимо собрать статистику по ценным бумагам фондированных аккаунтов в разрезе ticker
 * Статистика - сколько ценных бумаг и как много вложено денег
 * Фондированный аккаунт - valuation > 5000
 */

public class StatisticProblem {

    public static final BigDecimal VALUATION_LIMIT = BigDecimal.valueOf(5000L);

    public Map<String, Statistic> collectStatistic(List<BrokerageAccount> accounts) {
        return accounts.stream()
                .filter(brokerageAccount -> brokerageAccount.valuation.compareTo(VALUATION_LIMIT) > 0)
                .flatMap(brokerageAccount -> brokerageAccount.securities.stream())
                .collect(Collectors.toMap(security -> security.ticker,
                        security -> new Statistic(security.count, security.money),
                        (s1, s2) -> new Statistic(s1.count + s2.count, s1.sum.add(s2.sum))));
    }

    /**
     * Статистика
     */
    @Data
    @AllArgsConstructor
    public static class Statistic {
        private long count;
        private BigDecimal sum;
    }

    /**
     * Брокерский счет
     */
    @Data
    public static class BrokerageAccount {
        private String accountNumber;
        private BigDecimal valuation;
        private List<Security> securities;
    }

    /**
     * Ценная бумага. Пример, Security(ticker=VTB, count=10, money=2303.03)
     */
    @Data
    public static class Security {
        private String ticker;
        private int count;
        private BigDecimal money;
    }
}
