export class UtilStatic{
  static readonly  API_SOURCE: string = 'http://localhost:8080/';

  static arrayDeleteItem(array, item){
    const index = array.indexOf(item, 0);
    if (index > -1) {
      array.splice(index, 1);
    }
    return array;
  }


  static isTooDark(couleur:string): boolean{
    var c = couleur.substring(1);      // strip #
    var rgb = parseInt(c, 16);   // convert rrggbb to decimal
    var r = (rgb >> 16) & 0xff;  // extract red
    var g = (rgb >>  8) & 0xff;  // extract green
    var b = (rgb >>  0) & 0xff;  // extract blue

    var luma = 0.2126 * r + 0.7152 * g + 0.0722 * b; // per ITU-R BT.709
    if (luma < 127) {
      return true;
    }else{
      return false;
    }
  }
}
