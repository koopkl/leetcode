pub struct Solution {

}

impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let mut rm_other:String = s.as_str().as_bytes().into_iter().
            filter(|c| (**c as char).is_alphanumeric()).
            map(|x| (*x as char).to_lowercase().to_string() ).collect::<String>();
        let mut reverse: String = rm_other.clone().as_str().chars().rev().collect();
        println!("{reverse}==={rm_other}");
        reverse.as_str() == rm_other.as_str()


    }
}