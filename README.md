
As you know, we classify our loans by loan type - for example, Auto Loan, Adjustable Rate Mortgage, etc. We also have a hierarchy (tree) of loan types, so Adjustable Rate Mortgage is a type of Home Loan, which is a type of Consumer Loan. Your app lets us maintain this hierarchy by giving each loan type a "parent type".

We need a few reports developed, which are listed below in order of priority:

Report A: Output the loans in order retrieved from "server", with one block of information for each loan, and no indenting.

Report B: Output the loan types that have loans in alphabetical order, with all loans for that type shown under each loan type heading.

Report C: Output all loan types as a tree structure starting with the top "ALL" (All Loan Types) type, and indenting based on the level of the type within the tree. Show loans (if any) for each type below the type header, also indented to the level of the type.

For all of these, see the sample outputs provided.  Please note that we would ultimately like to have the reports be generated to either a file, or to screen output – but for now, just code this up to generate the report output to a file.

By the way, we change this hierarchy all the time, so please don't make any assumptions about number of levels, etc. We want the report to work even if we decide to have 10 levels.

