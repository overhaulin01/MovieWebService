<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body bgcolor="#FFF0F5">
  <h1 align="center">Movies Collection</h1>
    <table align="center" border="1" style="border-color:#778899;border-style: solid;border-width: 8px;">
      <tr bgcolor="#EE82EE">
        <th style="text-align:center" rowspan="2">Title</th>
        <th style="text-align:center" rowspan="2">Year</th>
	<th style="text-align:center" colspan="3">Types</th>
	<th style="text-align:center" rowspan="2">Time</th>
	<th style="text-align:center" rowspan="2">Directory</th>
      </tr>
      <tr bgcolor="#EE82EE">
	  <th style="text-align:center">Type1</th>
	  <th style="text-align:center">Type2</th>
	  <th style="text-align:center">Type3</th>      
      </tr>
      <xsl:for-each select="movies/film">
      <tr bgcolor="#F5F5F5">
	<td><xsl:value-of select="title"/></td>
	<td><xsl:value-of select="year"/></td>
	<td><xsl:value-of select="types/type[1]"/></td>
	<td><xsl:value-of select="types/type[2]"/></td>
	<td><xsl:value-of select="types/type[3]"/></td>
	<td><xsl:value-of select="time"/></td>
	<td><xsl:value-of select="director"/></td>
      </tr>
      </xsl:for-each>
   </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
