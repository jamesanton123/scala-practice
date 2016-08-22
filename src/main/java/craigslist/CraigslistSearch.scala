package craigslist

import utils.HttpUtils

object CraigslistSearch extends App {
  val list = CraigslistProductFinder.searchCraigslist("mustang")
  list.foreach { x => println(x) }
}

object CraigslistProductFinder {
  private val paramSearchString = "${param.searchString}"
  private val craigslistSearchUrl = "https://raleigh.craigslist.org/search/sss?s=100&query=" + paramSearchString + "&sort=rel"
  
  /**
   * A function to execute an http get request, and filter the results into a list using regex
   */
  val searchCraigslist = (searchTerm: String) => {
    val craigslistSearchResponse = HttpUtils.getSource(craigslistSearchUrl.replace(paramSearchString, searchTerm))
    val pattern = "<a.*?<span.*?</span></a>".r
    val links = pattern.findAllIn(craigslistSearchResponse)
    val isItem = (potentialItem: String) => { if (potentialItem.contains("titletextonly")) true else false }
    
    // Perform a 'for comprehension' on the list of items
    def forSaleItem(potentialItems: List[String]) = 
      for (potentialItem <- potentialItems if isItem(potentialItem)) yield potentialItem
   
    forSaleItem(links.toList)
  }
  
}

