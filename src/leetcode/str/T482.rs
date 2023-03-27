pub struct Solution {

}

impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        let mut res = vec![];
        let kk = s.replace("-", "");
        let first = kk.len()  % (k as usize);
        let bytes:Vec<char> = kk.chars().collect();
        let slice = &bytes[0..first];
        if slice.len() != 0 {
            let mut temp = String::new();
            slice.iter().for_each(|x| temp.push((*x)));
            res.push(temp);
        }
        let mut count = 0;
        let mut temp = String::new();
        for i in first..kk.len() {
            // println!("{temp}, {}", bytes[i].to_ascii_uppercase());
            if count == k {
                res.push(temp);
                temp = bytes[i].to_string();
                count = 1;
            } else {
                temp.push(bytes[i]);
                count += 1;
            }
        }
        if temp.len() > 0 {
            res.push(temp);
        }
        res.join("-").to_uppercase()
    }
}