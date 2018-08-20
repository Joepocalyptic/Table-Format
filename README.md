# Table Formatter
#### This tool is a Table Formatter that imports raw text from a file and turns it into a BBCode or HTML table. More languages are soon to come! This program is made with Java, more specifically the JavaFX Application libraries. You will need a valid [JRE](https://www.java.com/en/download/manual.jsp) to run it.
###### _Previously known as GlossaryFX._

Let's see how to use it!

---

Newlines are read as the table row separator. You may choose the table data separator within the program itself. Here's
a valid file if your data separator was '**_:_**':

___

>1:2  
>3:4  
>5:6  
>7:8  
>9:10  
>11:12  
>13:14  
>15:16  
>17:18  
>19:20  

___

This will turn into a formatted table with your choice of BBCode, HTML, compacted or aesthetic formatting, and `<table></table>` tagging!

If your separator doesn't happen to be **:**, just set it to whatever you preformatted! Remember, each table row is a newline ('\n' in the code), but the term/definition separator is defined by you before the formatting takes place.

Let's look at what this would process into assuming HTML formatting with table tagging, aesthetic indenting and newlines, and a '**_:_**' separator:

___
```html
<table>
<tr>
    <td>1</td>
    <td>2</td>
</tr>
<tr>
    <td>3</td>
    <td>4</td>
</tr>
<tr>
    <td>5</td>
    <td>6</td>
</tr>
<tr>
    <td>7</td>
    <td>8</td>
<!-- Cut for size. -->
</table>
```
___

I hope this project proves to be useful! I made it in my spare time, and as my first JavaFX project, I'd say it went quite well.

___

About Me:

Join my public Discord [here](www.discord.gg/XmPhseX).
Check out my YouTube Channel [here](www.bit.ly/joeisanub).
