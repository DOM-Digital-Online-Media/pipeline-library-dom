#!/usr/bin/env groovy
package com.domdom

class GlobalVars {
   static String foo = "bar"

   // refer to this in a pipeline using:
   //
   // import com.domdom.GlobalVars
   // println GlobalVars.foo
}
