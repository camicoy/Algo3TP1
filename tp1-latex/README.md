algo3-latex - Guía de Uso
=========================

- Instalar LaTeX: https://www.tug.org/texlive/quickinstall.html  
Recomiendo customizar la instalación y desactivar ítems como lenguajes que no sean español/inglés, cosas de música, etc, si no quieren esperar a que se instalen 4GB.

- Instalar fuentes recomendadas para evitar errores de compilación: `sudo apt-get install texlive-fonts-recommended` (después de instalar el `texlive` y reiniciar).

- para compilar el pdf:
`.../informe $ pdflatex informe.tex`

- listings package manual (para snippets de código con **resaltado de sintaxis**): http://ctan.dcc.uchile.cl/macros/latex/contrib/listings/listings.pdf

- clrscode3e package manual (para el **pseudocódigo**): http://www.cs.dartmouth.edu/~thc/clrscode/clrscode3e.pdf
