pub struct Solution {

}

impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        let str = word.as_bytes();
        if str.len() == 1 {
            return true
        }
        if (str[0] as char).is_lowercase() && str.iter().filter(|c| !(**c as char) .is_lowercase()).collect::<Vec<&u8>>().len() > 0{
            return false
        }
        if !(str[0] as char).is_lowercase() {
            let upper_len = str.iter().filter(|c| !(**c as char) .is_lowercase()).collect::<Vec<&u8>>().len();
            if upper_len != str.len() && upper_len != 1 {
                return false
            }
        }
        true
    }
}