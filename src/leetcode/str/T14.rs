pub struct Solution {

}

impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.len() == 1{
            return strs[0].clone()
        }
        let bytes = strs[0].as_bytes();
        let mut res: Vec<u8> = vec![];
        for i in 0..bytes.len() {
            let len = strs.iter().
                filter(|x|{
                    if (**x).len() <= i {
                        return false
                    }
                    ((**x).as_bytes()[i] == bytes[i])
                })
                .map(|x|(*x).clone()).collect::<Vec<String>>().len();
            if len != strs.len() {
                break
            } else {
                res.push(bytes[i]);
            }
        }
        res.iter().map(|x| *x as char).collect()
    }
}