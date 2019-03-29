case class Switch(isOn: Boolean){
  def toggle(switch: Switch): Switch = {
    if(switch.isOn) Switch(false) else Switch(true)
  }
}




