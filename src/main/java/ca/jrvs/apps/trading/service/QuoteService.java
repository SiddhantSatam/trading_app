package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.dto.IexQuote;
import ca.jrvs.apps.trading.model.dto.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class QuoteService {

    private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

    @Autowired
    public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao) {
        this.quoteDao = quoteDao;
        this.marketDataDao = marketDataDao;
    }
    /**
     * Helper method. Map a IexQuote to a Quote entity.
     * Note: `iexQuote.getLatestPrice() == null` if the stock market is closed.
     * Make sure set a default value for number field(s).
     */

    public Quote buildQuoteFromIexQuote(IexQuote iexQuote) {
        Quote quote = new Quote();

        if (iexQuote.getLatestPrice() !=null) {
            quote.setLastPrice(iexQuote.getLatestPrice());
            quote.setAskPrice(iexQuote.getIexAskPrice());
            quote.setAskSize(iexQuote.getIexAskSize());
            quote.setBidPrice(iexQuote.getIexBidPrice());
            quote.setBidSize(iexQuote.getIexBidSize());
            quote.setId(iexQuote.getSymbol());
            quote.setTicker(iexQuote.getSymbol());
        }

        if (quote == null)
            throw new IllegalArgumentException("Quote cannot be NULL");
        return quote;
    }

    /**
     * Add a list of new tickers to the quote table. Skip existing ticker(s).
     * - Get iexQuote(s)
     * - convert each iexQuote to Quote entity
     * - persist the quote to db
     *
     * @param tickers a list of tickers/symbols
     *                //  * @throws ca.jrvs.apps.trading.dao.ResourceNotFoundException if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */

    public void initQuotes(List<String> tickers) {

    }

    public void initQuote(String ticker) {
        initQuotes(Collections.singletonList(ticker));
    }

    /**
     * Update quote table against IEX source
     * - get all quotes from the db
     * - foreach ticker get iexQuote
     * - convert iexQuote to quote entity
     * - persist quote to db
     * <p>
     * //  * @throws ca.jrvs.apps.trading.dao.ResourceNotFoundException if ticker is not found from IEX
     *
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public void updateMarketData() {

    }
}
